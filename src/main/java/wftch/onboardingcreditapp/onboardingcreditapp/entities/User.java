
package wftch.onboardingcreditapp.onboardingcreditapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID interno generado por el sistema
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    
    //Número de identificación del usuario (DNI, cédula, pasaporte, etc.)
    @Column(nullable = false, unique = true)
    private String identificationNumber;
    
    //Tipo de identificación (por ejemplo, DNI, CUIT, PASAPORTE, etc.)
    @ManyToOne
    @JoinColumn(name = "identification_type_id", nullable = false)
    private IdentificationType identificationType;
    
    // Relación con roles (muchos a muchos)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    
    //Constructores

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


    
}
