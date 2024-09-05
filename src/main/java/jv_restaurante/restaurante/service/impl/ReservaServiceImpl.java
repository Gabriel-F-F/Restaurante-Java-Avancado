package jv_restaurante.restaurante.service.impl;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv_restaurante.restaurante.dto.ReservaDto;
import jv_restaurante.restaurante.entity.ClienteEntity;
import jv_restaurante.restaurante.entity.MesaEntity;
import jv_restaurante.restaurante.entity.ReservaEntity;
import jv_restaurante.restaurante.repository.ClienteRepository;
import jv_restaurante.restaurante.repository.MesaRepository;
import jv_restaurante.restaurante.repository.ReservaRepository;
import jv_restaurante.restaurante.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private MesaRepository mesaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public void validaDataReserva(LocalDate dataReserva) {
		if(dataReserva.isBefore(LocalDate.now())) {
			throw new DateTimeException("Data de Reserva Inválida!");
		}
	}
	
	@Override
	public ReservaDto postReserva(Long idCliente, Long idMesa, ReservaDto reservaDto) {
		validaDataReserva(reservaDto.getDataReserva());
		
		MesaEntity mesaEntity = mesaRepository.findMesaById(idMesa);
		ClienteEntity clienteEntity = clienteRepository.findClienteById(idCliente);
		ReservaEntity reservaAdicionada = reservaRepository.save(new ReservaEntity(reservaDto, clienteEntity, mesaEntity));
		return new ReservaDto(reservaAdicionada);
	}

	@Override
	public void putReserva(Long idReserva, ReservaDto reservaDto) {
		Optional<ReservaEntity> reservaEncontrada = reservaRepository.findById(idReserva);
		if (reservaEncontrada.isPresent()) {
			ReservaEntity reservaEntity = reservaEncontrada.get();
			reservaEntity.putReserva(reservaDto);
			reservaRepository.save(reservaEntity);
		}
	}

	@Override
	public void putStatusReserva(Long idReserva, ReservaDto reservaDto) {
		Optional<ReservaEntity> reservaEncontrada = reservaRepository.findById(idReserva);
		if (reservaEncontrada.isPresent()) {
			ReservaEntity reservaEntity = reservaEncontrada.get();
			reservaEntity.putStatusReserva(reservaDto);
			reservaRepository.save(reservaEntity);
		}
	}
}