
package lk.competelk.competelk_backend.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lk.competelk.competelk_backend.dto.CompetitionEditionResponse;
import lk.competelk.competelk_backend.service.CompetitionEditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/editions")
public class EditionQueryController {

    private final CompetitionEditionService editionService;

    // Returns editions in pages to avoid loading all records at once.
    @GetMapping
    public Page<CompetitionEditionResponse> getAllEditions(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) @Max(100) int size) {

        PageRequest pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.ASC, "id")
        );

        return editionService.getAllEditions(pageable);
    }

    // Returns a single edition or a 404 response if it does not exist.
    @GetMapping("/{id}")
    public CompetitionEditionResponse getEditionById(
            @PathVariable Long id) {

        return editionService.getEditionById(id);
    }
}
