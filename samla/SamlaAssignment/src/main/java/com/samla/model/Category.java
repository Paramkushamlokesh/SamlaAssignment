package com.samla.model;



import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
public class Category {
	@Id
	Integer id;
    String title;
    Timestamp created_at;  
    Timestamp updated_at;    
    Integer clues_count;
}
