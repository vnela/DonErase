package ohjelmistoprojekti.kyselysovellus.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    /*@Column(name = "password", nullable = false)
    private String passwordHash;
    @Column(name = "role", nullable = false)
    private String role;*/
    
    public User() {
    }

	public User(String username, String passwordHash, String email, String role) {
		super();
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}