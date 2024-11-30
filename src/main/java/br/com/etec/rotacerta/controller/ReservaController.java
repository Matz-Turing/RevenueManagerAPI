package br.com.etec.rotacerta.controller;

import br.com.etec.rotacerta.entity.Reserva;
import br.com.etec.rotacerta.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> listarTodasReservas() {
        List<Reserva> reservas = reservaService.listarTodasReservas();
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarReservaPorId(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaService.buscarReservaPorId(id);
        return reserva.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Reserva> salvarReserva(@RequestBody Reserva reserva) {
        Reserva reservaSalva = reservaService.salvarReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        reserva.setIdReserva(id);
        Reserva reservaAtualizada = reservaService.salvarReserva(reserva);
        return ResponseEntity.ok(reservaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable Long id) {
        reservaService.deletarReserva(id);
        return ResponseEntity.noContent().build();
    }
}