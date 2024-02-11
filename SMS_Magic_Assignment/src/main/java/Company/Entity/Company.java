package Company.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing a company.
 */
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String industry;

    // Constructors...

    /**
     * Default constructor for JPA.
     */
    public Company() {
    }

    /**
     * Constructor to initialize a company with a name and industry.
     *
     * @param name     The name of the company.
     * @param industry The industry in which the company operates.
     */
    public Company(String name, String industry) {
        this.name = name;
        this.industry = industry;
    }

    // Getters and Setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    // Other methods...

    /**
     * Returns a string representation of the company.
     *
     * @return A string representation of the company.
     */
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", industry='" + industry + '\'' +
                '}';
    }

    /**
     * Checks if two companies are equal based on their IDs.
     *
     * @param o The object to compare.
     * @return True if the companies are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id);
    }

    /**
     * Generates a hash code for the company based on its ID.
     *
     * @return The hash code for the company.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
