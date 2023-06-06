package com.sp.authservice.service;

import com.sp.authservice.Dto.LoggerUserInfoDto;
import com.sp.authservice.Dto.UserInfoCache;
import com.sp.authservice.Dto.UserSignUpDto;
import com.sp.authservice.domain.UserPool;
import com.sp.authservice.exceptions.CustomException;
import com.sp.authservice.repo.UserPoolRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserPoolRepository userPoolRepository;
    private final SmsService smsService;
    private final RedisTemplate<String, UserInfoCache> redisTemplate;

    @Transactional
    public void registerUser(UserSignUpDto userSignUpDto) {
        userPoolRepository.findByPhoneNo(userSignUpDto.getPhoneNo())
            .ifPresent(userPool -> {throw new EntityExistsException("username already exists");
            });

        Random random = new Random();
        Integer otp = random.nextInt(899999) + 100001;
        smsService.sendSms(userSignUpDto.getPhoneNo(),String.format("Hello! Your OTP for savy-tax user registration is: %d. " +
            "Please enter this OTP within next 5 minutes to complete your signup process. Thank you!",otp));
        UserInfoCache userInfoCache = new UserInfoCache(userSignUpDto);
        userInfoCache.setOtp(otp);
        redisTemplate.opsForHash().put(userSignUpDto.getPhoneNo(), userSignUpDto.getPhoneNo(), userInfoCache);
        redisTemplate.expire(userSignUpDto.getPhoneNo(), 5, TimeUnit.MINUTES);

    }


    public LoggerUserInfoDto validateOtp(String phoneNo, String otp, String validationType) {
        Optional<UserInfoCache> userOtp;
        Optional<UserPool> userPool = null;

        userOtp = Optional.ofNullable((UserInfoCache) redisTemplate.opsForHash().get(phoneNo, phoneNo));
        if(userOtp.isEmpty()){
            throw new CustomException(" otp expired please register again.");
        }
        if(!userOtp.get().getOtp().toString().equals(otp)){
            throw new CustomException("invalid otp! please provide a valid otp.");
        }
        if(validationType.equals("register")) {
            userPool= Optional.ofNullable(userPoolRepository.save(new UserPool(userOtp.get())));
        }
        else if(validationType.equals("login")){
            userPool = userPoolRepository.findByPhoneNo(phoneNo);
        }

        return new LoggerUserInfoDto(userPool.get());
    }

    public void UserloginWithOtp(String phoneNo) {

      Optional<UserPool> user = userPoolRepository.findByPhoneNo(phoneNo);
      if(user.isEmpty()){
          throw new CustomException("user does not exist please register first.");
      }
        Random random = new Random();
        Integer otp = random.nextInt(899999) + 100001;
        smsService.sendSms(phoneNo,String.format("Hello! Your OTP for savy-tax user registration is: %d " +
            "Please enter this OTP within next 5 minutes to login. Thank you!",otp));
        UserInfoCache userInfoCache = new UserInfoCache();
        userInfoCache.setOtp(otp);
        redisTemplate.opsForHash().put(phoneNo,phoneNo, userInfoCache);
        redisTemplate.expire(phoneNo, 5, TimeUnit.MINUTES);
    }
}
