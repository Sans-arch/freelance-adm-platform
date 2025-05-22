package com.github.sansarch.freelance_adm_platform.infrastructure.persistence.mapper;

import com.github.sansarch.freelance_adm_platform.application.usecase.user.UserFactory;
import com.github.sansarch.freelance_adm_platform.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.Document;
import com.github.sansarch.freelance_adm_platform.domain.entity.vo.UserId;
import com.github.sansarch.freelance_adm_platform.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.infrastructure.persistence.model.UserModel;

public class UserMapper {

    public static User toDomainObject(UserModel model) {
        var user = UserFactory.restoreUser(
                UserId.from(model.getId()),
                model.getName(),
                model.getEmail(),
                model.getPhone(),
                new Document(model.getDocument(), DocumentType.valueOf(model.getDocumentType())),
                null,
                AccountType.CUSTOMER
        );

        return user;
    }

    public static UserModel toModel(User user) {
        return new UserModel(
                user.getId().getValue(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getDocument().getValue(),
                user.getDocument().getType().name()
        );
    }
}
