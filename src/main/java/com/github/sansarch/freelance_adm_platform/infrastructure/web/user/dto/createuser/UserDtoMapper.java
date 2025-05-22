package com.github.sansarch.freelance_adm_platform.infrastructure.web.user.dto.createuser;

import com.github.sansarch.freelance_adm_platform.application.usecase.user.dto.CreateUserDto;

import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.domain.enums.DocumentType;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public static CreateUserDto toInternalCreateUserUseCaseDto(CreateUserRequestDto createUserRequestDto) {
        var document = new Document(
                createUserRequestDto.document().value(),
                DocumentType.valueOf(createUserRequestDto.document().type().name())
        );

        var accounts = createUserRequestDto.accounts()
                .stream()
                .map(accountType -> AccountType.valueOf(accountType.name()))
                .toList();

        var mainAccount = AccountType.valueOf(createUserRequestDto.mainAccount().name());

        return new CreateUserDto(
                createUserRequestDto.name(),
                createUserRequestDto.email(),
                createUserRequestDto.phone(),
                document,
                accounts,
                mainAccount
        );
    }
}
