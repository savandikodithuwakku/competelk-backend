package lk.competelk.competelk_backend.controller;

import lk.competelk.competelk_backend.dto.CompetitionEditionResponse;
import lk.competelk.competelk_backend.service.CompetitionEditionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/editions")
public class EditionQueryController {

    private final CompetitionEditionService editionService;

    public EditionQueryController(CompetitionEditionService editionService) {
        this.editionService = editionService;
    }

    @GetMapping
    public Page<CompetitionEditionResponse> getAllEditions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        int safePage = Math.max(0, page);
        int safeSize = Math.max(1, Math.min(size, 100));

        PageRequest pageable = PageRequest.of(
                safePage,
                safeSize,
                Sort.by(Sort.Direction.ASC, "id")
        );

        return editionService.getAllEditions(pageable);
    }

    @GetMapping("/{id}")
    public CompetitionEditionResponse getEditionById(@PathVariable Long id) {
        return editionService.getEditionById(id);
    }
}