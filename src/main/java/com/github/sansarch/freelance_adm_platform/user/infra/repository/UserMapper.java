package com.github.sansarch.freelance_adm_platform.user.infra.repository;

import com.github.sansarch.freelance_adm_platform.user.domain.factory.UserFactory;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.User;
import com.github.sansarch.freelance_adm_platform.shared.domain.vo.Document;
import com.github.sansarch.freelance_adm_platform.user.domain.entity.UserId;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.AccountType;
import com.github.sansarch.freelance_adm_platform.shared.domain.enums.DocumentType;
import com.github.sansarch.freelance_adm_platform.user.infra.repository.model.UserModel;

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
