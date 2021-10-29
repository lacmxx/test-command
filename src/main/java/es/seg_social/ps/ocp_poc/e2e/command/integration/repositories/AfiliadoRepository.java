package es.seg_social.ps.ocp_poc.e2e.command.integration.repositories;

import es.seg_social.ps.ocp_poc.e2e.command.integration.model.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliadoRepository extends JpaRepository<Afiliado, Integer> {
}
