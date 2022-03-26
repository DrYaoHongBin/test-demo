package com.example.jpademo.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author mluhui
 * @date 2021/3/30
 **/
@SuppressWarnings("JpaDataSourceORMInspection")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_session_member")
@ToString
@Slf4j
public class Member {

    @Id
    @Column(name = "c_id", columnDefinition = "binary(16)")
    private UUID id;

    @Column(name = "number", columnDefinition = "bigint(20)")
    private long number;

}
