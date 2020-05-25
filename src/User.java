public class User {
    private int userid;
    private String name;
    private boolean gender;
    private String phone;
    private String address;

    public User(){

    }

    public User(String name, boolean gender, String phone, String address){
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public User(int userid, String name, boolean gender, String phone, String address){
        this.userid = userid;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
