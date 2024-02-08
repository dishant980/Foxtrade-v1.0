public class referraltable {

    private String SrNo;
    private String  Name;
    private String Referralcode;
    private String Selfinvestment;
    private String Teamsize;
    private String Teambusiness;

    public referraltable(){

    }
public referraltable(String Srno, String Name, String Referralcode, String Selfinvestment, String Teamsize, String Teambusiness)
{
this.SrNo = Srno;
this.Name= Name;
this.Referralcode=Referralcode;
this.Selfinvestment=Selfinvestment;
this.Teamsize=Teamsize;
this.Teambusiness=Teambusiness;
}
  public String getSrNo(){
  return SrNo;
    }
    public String getName(){
        return Name;
    }
    public String getReferralcode(){
        return Referralcode;
    }
    public String getSelfinvestment(){
        return Selfinvestment;
    }
    public String getTeamsize(){
        return Teamsize;
    }
    public String getTeambusiness(){
        return Teambusiness;
    }

}
