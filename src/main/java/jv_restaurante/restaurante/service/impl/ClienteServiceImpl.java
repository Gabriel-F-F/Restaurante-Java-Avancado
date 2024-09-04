package jv_restaurante.restaurante.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jv_restaurante.restaurante.dto.ClienteDto;
import jv_restaurante.restaurante.entity.ClienteEntity;
import jv_restaurante.restaurante.entity.RestauranteEntity;
import jv_restaurante.restaurante.repository.ClienteRepository;
import jv_restaurante.restaurante.repository.RestauranteRepository;
import jv_restaurante.restaurante.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Override
	public List<ClienteDto> getClientePorRestaurante(Long idRestaurante) {
		List<ClienteEntity> listaCliente = clienteRepository.findAll();
		List<ClienteEntity> clientesEncontrados = listaCliente
														.stream()
														.filter(cliente -> cliente.getRestaurante().getId().equals(idRestaurante))
														.toList();
		return clientesEncontrados.stream().map(ClienteDto::new).toList();
	}
	
	@Override
	public ClienteDto postCliente(Long idRestaurante, ClienteDto dto) {
		RestauranteEntity restauranteEntity = restauranteRepository.findRestauranteById(idRestaurante);
		ClienteEntity clienteAdicionado = clienteRepository.save(new ClienteEntity(dto, restauranteEntity));
		return new ClienteDto(clienteAdicionado);
	}
	
	@Override
	public void putCliente(Long idCliente, ClienteDto clienteDto) {
		Optional<ClienteEntity> clienteEncontrado = clienteRepository.findById(idCliente);
		if(clienteEncontrado.isPresent()) {
			ClienteEntity clienteEntity = clienteEncontrado.get();
			clienteEntity.putCliente(clienteDto);
			clienteRepository.save(clienteEntity);
		}
	}
}