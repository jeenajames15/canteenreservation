package com.uel.CanteenReservationSystem.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 3466316814573811482L;

	@Column(name = "ISACTIVE", nullable = false)
	@Basic(optional = false)
	private Boolean active;

	@Column(name = "CREATE_USER_ID", nullable = false)
	@Basic(optional = false)
	private String createUserID;

	@Column(name = "UPDATE_USER_ID", nullable = false)
	@Basic(optional = false)
	private String updateUserID;

	@CreationTimestamp
	@Column(name = "CREATE_DATE", nullable = false)
	@Basic(optional = false)
	private OffsetDateTime createDate;

	@UpdateTimestamp
	@Column(name = "UPDATE_DATE", nullable = false)
	@Basic(optional = false)
	private OffsetDateTime updateDate;

}
