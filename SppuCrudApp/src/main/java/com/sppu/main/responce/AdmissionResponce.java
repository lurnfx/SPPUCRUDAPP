package com.sppu.main.responce;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AdmissionResponce<T> {
	@NonNull
	private Integer statusCode;
	@NonNull
	private String msg;
	private LocalTime localTime = LocalTime.now();
	private LocalDate date = LocalDate.now();
	@NonNull
	private T body;

	
}
