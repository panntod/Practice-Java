package Project.Laundry;

// Pakai Abstract
abstract class User {
    public abstract  void setName(String name);
    public abstract  void setAddress(String address);
    public abstract void setPhoneNumber(String phoneNumber);
    public abstract void setEmail(String email);

    public abstract String getName(Integer id);
    public abstract String getAddress(Integer id);
    public abstract String getPhoneNumber(Integer id);
    public abstract String getEmail(Integer id);
}