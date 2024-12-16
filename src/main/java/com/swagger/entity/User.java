package com.swagger.entity;

import com.swagger.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="user_account")
public class User extends  BaseEntity{

    private String email;
    private String password;
    private String username;

    @Enumerated(EnumType.STRING)
    private UserRole role=UserRole.USER;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "account_details_id")
    private Account account;
}
