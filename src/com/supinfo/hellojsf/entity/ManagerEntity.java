package com.supinfo.hellojsf.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@Entity
@DiscriminatorValue("manager")
public class ManagerEntity extends UserEntity implements Serializable {


}
