package com.fxt.exchange;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    @POST("login")
    Call <LoginResponse> userLogin(@Body LoginRequest loginRequest);
    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST("main-dashboard")
    Call<DashboardResponse>fetchUserDashboardDetails(@Body UserId userID);

    @POST("referral-list")
    Call<ResponseModel>fetch_referrals_with_id(@Body UserId userID);

    @POST("wallet-ledger")
    Call<TransactionResponse>fetchMyWalletLedger(@Body UserId userId);

    @POST("commission-roi")
    Call<CommissionResponse>fetchMyCommision(@Body UserId userId);

    @POST("roi")
    Call<InvestmentResponse>fetchmyRoi(@Body UserId userId);

    @POST("salaries")
    Call<SalaryResponse>fetchmySalary(@Body UserId userID);

    @POST("self-investment")
    Call<UserWalletResponse>fetchmyInvestment(@Body UserId userId);

    @POST("funds-transfer")
    Call<FundResponse>fetchmyfund(@Body UserId userId);

    @GET("getBeneficiaryName/{referCode}")
    Call<BeneficiaryResponse>getBeneficiaryName(@Path("referCode") String referCode );

    @POST("save-transfer-funds")
    Call<FundTransferResponse> saveTransferFunds(@Body FundTransferRequest request);

    @POST("save-self-investment")
    Call<SelfinvestmentResponse>saveSelfInvestment(@Body self_investment_funds selfInvestmentFunds);

    @POST("user/profile")
    Call<UpdatepasswordResponse>savePassword(@Body updatePassword password);
    @POST("verify-kyc")
    Call<KycStatusResponse>verifyStatus(@Body UserId userId);

    @POST("submit-kyc")
    Call<SubmitKycResponse>submitResponse(@Body KycRegister kycRegister);
}


