package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "School")
public class School {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "school_number")
    private int schoolNumber;

/*    @Column(name = "principal_id")
    private int principalId;*/

    @OneToOne
    @JoinColumn(name = "principal_id", referencedColumnName = "id")
    private Principal principal;

    public School() {
    }

    public School(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

/*    public int getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(int principalId) {
        this.principalId = principalId;
    }*/

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolNumber=" + schoolNumber +
                '}';
    }
}
