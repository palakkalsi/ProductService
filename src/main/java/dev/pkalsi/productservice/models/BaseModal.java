package dev.pkalsi.productservice.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModal {
    @Id
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private boolean isDeleted;
}
