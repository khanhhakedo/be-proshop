package com.vti.form;

import com.vti.entity.Category;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class FormSeachProduct {

    private String name;
    private Float price_start;
    private Float price_end;

}
