package com.SchoolJasper.SchoolJasper.BaseEntity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    private LocalDateTime createdDate;
    private boolean isActive;
    private LocalDateTime updatedDate;
}
