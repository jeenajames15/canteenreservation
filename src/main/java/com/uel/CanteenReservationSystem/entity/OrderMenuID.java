package com.uel.CanteenReservationSystem.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
@Builder
@Setter
@Getter
@AllArgsConstructor
public class OrderMenuID implements Serializable {
	
	private static final long serialVersionUID = 4408389014720723981L;

	@Column(name = "ORDER_ID")
	private String orderId;

	@Column(name = "FOOD_ID")
	private String foodId;
}
