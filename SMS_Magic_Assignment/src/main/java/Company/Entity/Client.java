package Company.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Client {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false)
 private String name;

 @ManyToOne
 @JoinColumn(name = "user_id", nullable = false)
 private User user;

 @ManyToOne
 @JoinColumn(name = "company_id", nullable = false)
 private Company company;

 @Column(nullable = false, unique = true)
 private String email;

 @Column(nullable = false)
 private String phone;

 @Column(nullable = false)
 private boolean active; 

 
 public Client() {
 }

 public Client(String name, User user, Company company, String email, String phone) {
	    this.name = name;
	    this.user = user;
	    this.company = company;
	    this.email = email;
	    this.phone = phone;
	}



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

 public User getUser() {
     return user;
 }

 public void setUser(User user) {
     this.user = user;
 }

 public Company getCompany() {
     return company;
 }

 public void setCompany(Company company) {
     this.company = company;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public String getPhone() {
     return phone;
 }

 public void setPhone(String phone) {
     this.phone = phone;
 }

 public boolean isActive() {
     return active;
 }

 public void setActive(boolean active) {
     this.active = active;
 }

 // Other methods, equals, hashCode, etc.

 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;
     Client client = (Client) o;
     return Objects.equals(id, client.id);
 }

 @Override
 public int hashCode() {
     return Objects.hash(id);
 }

 @Override
 public String toString() {
     return "Client{" +
             "id=" + id +
             ", name='" + name + '\'' +
             ", user=" + user +
             ", company=" + company +
             ", email='" + email + '\'' +
             ", phone='" + phone + '\'' +
             ", active=" + active +
             '}';
 }
}
