package com.example.client.dto;

public class MemberDto {
    private String name;
    private String email;
    private String organization;

    // 기본 생성자
    public MemberDto() {}

    // 3 필드 생성자
    public MemberDto(String name, String email, String organization) {
        this.name = name;
        this.email = email;
        this.organization = organization;
    }

    // Getter, Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "MemberDto {" +
                "name ='" + name + '\'' +
                ", email ='" + email + '\'' +
                ", organization ='" + organization + '\'' +
                "}";
    }
}
