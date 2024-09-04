package jv_restaurante.restaurante.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv_restaurante.restaurante.repository.ReservaRepository;
import jv_restaurante.restaurante.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	
}