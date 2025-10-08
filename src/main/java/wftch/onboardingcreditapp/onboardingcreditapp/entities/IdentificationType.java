
package wftch.onboardingcreditapp.onboardingcreditapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "identification_types")
class IdentificationType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // Ejemplo: "DNI", "CUIT", "PASAPORTE"
    
    //Constructores

    public IdentificationType() {
    }

    public IdentificationType(String name) {
        this.name = name;
    }
    
    
}
