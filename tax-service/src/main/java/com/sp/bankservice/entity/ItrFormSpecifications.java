package com.sp.bankservice.entity;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class ItrFormSpecifications {

    private String residentialStatus;

    private String taxPayerType;
    private boolean incomeFromSalaryOrPension;
    private boolean incomeGreaterThan50lpa;
    private boolean incomeFromMoreThanOneHouse;
    private boolean agriculturalIncomeMoreThan5k;
    private boolean incomeFromOtherSources;
    private boolean incomeFromCapitalGains;
    private boolean holdingUnlistedShares;
    private boolean holdingCompanyDirectorship;
    private boolean holdingForeignIncomeOrAssets;
    private boolean incomeFromBusiness;
    private boolean incomeAsPartner;

    private List<String> formType = new ArrayList<>();

    public String getResidentialStatus() {
        return residentialStatus;
    }

    public void setResidentialStatus(String residentialStatus) {
        this.residentialStatus = residentialStatus;
    }

    public String getTaxPayerType() {
        return taxPayerType;
    }

    public void setTaxPayerType(String taxPayerType) {
        this.taxPayerType = taxPayerType;
    }

    public boolean isIncomeFromSalaryOrPension() {
        return incomeFromSalaryOrPension;
    }

    public void setIncomeFromSalaryOrPension(boolean incomeFromSalaryOrPension) {
        this.incomeFromSalaryOrPension = incomeFromSalaryOrPension;
    }

    public boolean isIncomeGreaterThan50lpa() {
        return incomeGreaterThan50lpa;
    }

    public void setIncomeGreaterThan50lpa(boolean incomeGreaterThan50lpa) {
        this.incomeGreaterThan50lpa = incomeGreaterThan50lpa;
    }

    public boolean isIncomeFromMoreThanOneHouse() {
        return incomeFromMoreThanOneHouse;
    }

    public void setIncomeFromMoreThanOneHouse(boolean incomeFromMoreThanOneHouse) {
        this.incomeFromMoreThanOneHouse = incomeFromMoreThanOneHouse;
    }

    public boolean isAgriculturalIncomeMoreThan5k() {
        return agriculturalIncomeMoreThan5k;
    }

    public void setAgriculturalIncomeMoreThan5k(boolean agriculturalIncomeMoreThan5k) {
        this.agriculturalIncomeMoreThan5k = agriculturalIncomeMoreThan5k;
    }

    public boolean isIncomeFromOtherSources() {
        return incomeFromOtherSources;
    }

    public void setIncomeFromOtherSources(boolean incomeFromOtherSources) {
        this.incomeFromOtherSources = incomeFromOtherSources;
    }

    public boolean isIncomeFromCapitalGains() {
        return incomeFromCapitalGains;
    }

    public void setIncomeFromCapitalGains(boolean incomeFromCapitalGains) {
        this.incomeFromCapitalGains = incomeFromCapitalGains;
    }

    public boolean isHoldingUnlistedShares() {
        return holdingUnlistedShares;
    }

    public void setHoldingUnlistedShares(boolean holdingUnlistedShares) {
        this.holdingUnlistedShares = holdingUnlistedShares;
    }

    public boolean isHoldingCompanyDirectorship() {
        return holdingCompanyDirectorship;
    }

    public void setHoldingCompanyDirectorship(boolean holdingCompanyDirectorship) {
        this.holdingCompanyDirectorship = holdingCompanyDirectorship;
    }

    public boolean isHoldingForeignIncomeOrAssets() {
        return holdingForeignIncomeOrAssets;
    }

    public void setHoldingForeignIncomeOrAssets(boolean holdingForeignIncomeOrAssets) {
        this.holdingForeignIncomeOrAssets = holdingForeignIncomeOrAssets;
    }

    public boolean isIncomeFromBusiness() {
        return incomeFromBusiness;
    }

    public void setIncomeFromBusiness(boolean incomeFromBusiness) {
        this.incomeFromBusiness = incomeFromBusiness;
    }

    public boolean isIncomeAsPartner() {
        return incomeAsPartner;
    }

    public void setIncomeAsPartner(boolean incomeAsPartner) {
        this.incomeAsPartner = incomeAsPartner;
    }

    public List<String> getFormType() {
        return formType;
    }

    public void setFormType(List<String> formType) {
        this.formType = formType;
    }
}
