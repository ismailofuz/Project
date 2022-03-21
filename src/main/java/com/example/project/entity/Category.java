package com.example.project.entity;

import com.example.project.entity.template.AbsNameEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Category extends AbsNameEntity {
}
