package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterRisultato;
import it.contrader.dao.RisultatoRepository;
import it.contrader.dto.RisultatoDTO;
import it.contrader.model.Risultato;

@Service
public class RisultatoService {

	private final RisultatoRepository risultatoRepository;

	@Autowired
	public RisultatoService(RisultatoRepository risultatoRepository) {
		this.risultatoRepository = risultatoRepository;
	}

	public List<RisultatoDTO> getListaRisultatoDTO() {
		return ConverterRisultato.toListDTO((List<Risultato>) risultatoRepository.findAll());
	}

	public RisultatoDTO getRisultatoDTOById(Integer id) {
		return ConverterRisultato.toDTO(risultatoRepository.findById(id).get());
	}


	public RisultatoDTO getByDescrizione(String descrizione) {

		final Risultato risultato = risultatoRepository.findRisultatoByDescrizione(descrizione);

		return ConverterRisultato.toDTO(risultato);
	}

	public boolean insertRisultato(RisultatoDTO risultatoDTO) {
		return risultatoRepository.save(ConverterRisultato.toEntity(risultatoDTO)) != null;
	}

	public boolean updateRisultato(RisultatoDTO risultatoDTO) {
		return risultatoRepository.save(ConverterRisultato.toEntity(risultatoDTO)) != null;
	}
	
	public void deleteRisultatoById(Integer id) {
		risultatoRepository.deleteById(id);
	}

	public List<RisultatoDTO> findRisultatoDTOById(Integer content) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
//	public List<RisultatoDTO> findRisultatoDTOById(Integer id) {
//		
//		final List<Risultato> list = risultatoRepository.findAllById(id);
//		final List<RisultatoDTO> risultatoDTOs = new ArrayList<>();
//		list.forEach(i -> risultatoDTOs.add(ConverterRisultato.toDTO(i)));
//		return risultatoDTOs;
//		
//	
//	}

	
	
	
}
