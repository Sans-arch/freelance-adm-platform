package com.github.sansarch.freelance_adm_platform.infrastructure.persistence.mapper;

import com.github.sansarch.freelance_adm_platform.application.usecase.user.UserFactory;
import com.github.sansarch.freelance_adm_platform.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.domain.shared.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.UserId;
import com.github.sansarch.freelance_adm_platform.domain.shared.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.domain.shared.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.model.UserModel;

public class UserMapper {

    public static User toDomainObject(UserModel model) {
        return UserFactory.restoreUser(
                UserId.from(model.getId()),
                model.getName(),
                model.getEmail(),
                model.getPhone(),
                model.getPassword(),
                new Document(model.getDocument(), DocumentType.valueOf(model.getDocumentType())),
                null,
                AccountType.CUSTOMER
        );
    }

    public static UserModel toModel(User user) {
        return new UserModel(
                user.getId().getValue(),
                user.getName(),
                user.getEmail().getValue(),
                user.getPhone(),
                user.getPassword(),
                user.getDocument().getValue(),
                user.getDocument().getType().name()
        );
    }
}
