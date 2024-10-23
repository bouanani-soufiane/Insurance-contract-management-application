package ma.yc.user.domain.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ma.yc.user.domain.valueObject.UserId;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @EmbeddedId
    private UserId id;

    @NotBlank
    private String username;

    @Email
    private String email;

    @Size(min = 6)
    private String password;

    @Pattern(regexp = "^(\\+212\\s?|0)(6|7)[0-9]{8}|((0(2|5)[0-9]{7}))$", message = "Phone must be a valid Moroccan format (e.g., 0601234567 or +212 6 0123 4567)")
    private String phone;

    @NotBlank
    private String address;

    public User ( UserId id, String username, String email, String password, String phone, String address ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public User ( String username, String email, String password, String phone, String address ) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }


}
