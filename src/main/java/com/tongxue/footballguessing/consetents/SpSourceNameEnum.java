package com.tongxue.footballguessing.consetents;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum SpSourceNameEnum {
	AVERAGE("average","平均"),
	OFFICIAL("official","官方"),
	WILLIAM("william","威廉"),
	AOMEN("aomen","澳门"),
	LIBO("lb","立博"),
	BET365("bet365","Bet365"),
	HONGKONG("hongkong","香港"),
	;
	private String type;
	private String cnName;
	}
