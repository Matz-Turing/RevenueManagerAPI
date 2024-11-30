package br.com.etec.rotacerta.service;

import br.com.etec.rotacerta.entity.Reserva;
import br.com.etec.rotacerta.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional
    public Reserva salvarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarTodasReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> buscarReservaPorId(Long id) {
        return reservaRepository.findById(id);
    }

    @Transactional
    public void deletarReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    public boolean existeReserva(Long id) {
        return reservaRepository.existsById(id);
    }
}