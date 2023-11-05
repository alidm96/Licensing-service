package com.optimagrowth.license.service;

import lombok.RequiredArgsConstructor;
import com.optimagrowth.license.model.License;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LicenseService {

    private final MessageSource messages;
    private final Random random = new Random();

    public License getLicense(String licenseId, String organizationId) {

        License license = new License();

        license.setLicenseType("full");
        license.setLicenseId(licenseId);
        license.setProductName("O-stock");
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setId(random.nextInt(1000));

        return license;

    }

    public String createLicense(License license, String organizationId, Locale locale) {

        String responseMessage = null;

        if (license != null) {

            license.setOrganizationId(organizationId);
            responseMessage =
                    String.format(messages.getMessage("license.create.message", null,locale), license);

        }

        return responseMessage;

    }

    public String updateLicense(License license, String organizationId, Locale locale) {

        String responseMessage = null;

        if (license != null) {

            license.setOrganizationId(organizationId);
            responseMessage =
                    String.format(messages.getMessage("license.update.message", null, locale), license);

        }

        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId, Locale locale) {

        return String.format(messages.getMessage("license.delete.message", null, locale), licenseId, organizationId);

    }

}
