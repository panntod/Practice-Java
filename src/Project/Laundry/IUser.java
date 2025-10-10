package Project.Laundry;

// Pakai Interface
public interface IUser {
    void setName(String name);

    void setAddress(String address);

    void setPhoneNumber(String phoneNumber);

    void setEmail(String email);

    String getName(Integer id);

    String getAddress(Integer id);

    String getPhoneNumber(Integer id);

    String getEmail(Integer id);
}
