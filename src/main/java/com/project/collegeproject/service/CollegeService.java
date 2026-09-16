package com.project.collegeproject.service;

import com.project.collegeproject.enums.Status;
import com.project.collegeproject.enums.Type;
import com.project.collegeproject.model.CollegeEntity;
import com.project.collegeproject.repository.CollegeRepository;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;
//    @Autowired
//    private AddressRepository addressRepository;

    public List<CollegeEntity> getAllColleges() {
        return collegeRepository.findAll();
    }

    public Optional<CollegeEntity> getCollegeByCode(String collegeCode) {
        if (StringUtils.isBlank(collegeCode)) {
            return Optional.empty();
        }
        return collegeRepository.findByCollegeCode(collegeCode);
    }

    public List<CollegeEntity> getCollegeByName(String collegeName) {
        if (StringUtils.isBlank(collegeName)) {
            return null;
        }
        return collegeRepository.findByCollegeName(collegeName);
    }

    public Optional<CollegeEntity> getCollegeByEmail(String collegeEmail) {
        if (StringUtils.isBlank(collegeEmail)) {
            return Optional.empty();
        }
        return collegeRepository.findByCollegeEmail(collegeEmail);
    }

    public Optional<CollegeEntity> getCollegeByPhoneNumber(String collegePhoneNumber) {
        if (StringUtils.isBlank(collegePhoneNumber)) {
            return Optional.empty();
        }
        return collegeRepository.findByCollegePhoneNumber(collegePhoneNumber);
    }

    public List<CollegeEntity> getCollegeByPinCode(String pinCode) {
        if (StringUtils.isBlank(pinCode)) {
            return null;
        }
        return collegeRepository.findByCollegeAddress_PinCode(pinCode);
    }

    public List<CollegeEntity> getCollegeByCity(String city) {
        if (StringUtils.isBlank(city)) {
            return null;
        }
        return collegeRepository.findByCollegeAddress_City(city);
    }

    public List<CollegeEntity> getCollegeByState(String state) {
        if (StringUtils.isBlank(state)) {
            return null;
        }
        return collegeRepository.findByCollegeAddress_State(state);
    }

    public List<CollegeEntity> getCollegeByCountry(String country) {
        if (StringUtils.isBlank(country)) {
            return null;
        }
        return collegeRepository.findByCollegeAddress_Country(country);
    }

    public List<CollegeEntity> getCollegeByPinCodeAndCountry(String pinCode, String country) {
        if (StringUtils.isBlank(pinCode) || StringUtils.isBlank(country)) {
            return null;
        }
        return collegeRepository.findByCollegeAddress_PinCodeAndCollegeAddress_Country(pinCode, country);
    }

    public List<CollegeEntity> getCollegeByPinCodeAndCollegeType(String pinCode, Type collegeType) {
        if (StringUtils.isBlank(pinCode) || ObjectUtils.isEmpty(collegeType)) {
            return null;
        }
        return collegeRepository.findByCollegeAddress_PinCodeAndCollegeType(pinCode, collegeType);
    }

    public List<CollegeEntity> getCollegeByPinCodeAndCollegeTypeAndCollegeStatus(String pinCode, Type collegeType, Status collegeStatus) {
        if (StringUtils.isBlank(pinCode) || ObjectUtils.isEmpty(collegeType) || ObjectUtils.isEmpty(collegeStatus)) {
            return null;
        }
        return collegeRepository.findByCollegeAddress_PinCodeAndCollegeTypeAndCollegeStatus(pinCode, collegeType, collegeStatus);
    }

    public List<CollegeEntity> getCollegeByType(Type collegeType) {
        if (ObjectUtils.isEmpty(collegeType)) {
            return null;
        }
        return collegeRepository.findByCollegeType(collegeType);
    }

    public List<CollegeEntity> getCollegeByStatus(Status collegeStatus) {
        if (ObjectUtils.isEmpty(collegeStatus)) {
            return null;
        }
        return collegeRepository.findByCollegeStatus(collegeStatus);
    }

    public String addCollege(CollegeEntity collegeEntity) {
        if (ObjectUtils.isEmpty(collegeEntity)) {
            return "Invalid College, Please Write College Details";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeCode()) || !collegeEntity.getCollegeCode().matches("^[a-zA-Z0-9]+$")) {
            return "Invalid College Code";
        }
        if (collegeRepository.findByCollegeCode(collegeEntity.getCollegeCode()).isPresent()) {
            return "College Code Already Exists";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeName()) || !collegeEntity.getCollegeName().matches("^[a-zA-Z ]+$")) {
            return "Invalid College Name";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeEmail()) || !collegeEntity.getCollegeEmail().matches("^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
            return "Invalid College Email";
        }
        if (collegeRepository.findByCollegeEmail(collegeEntity.getCollegeEmail()).isPresent()) {
            return "College Email Already Exists";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegePhoneNumber()) || !collegeEntity.getCollegePhoneNumber().matches("^[6-9][0-9]{9}$")) {
            return "Invalid College Phone Number";
        }
        if (collegeRepository.findByCollegePhoneNumber(collegeEntity.getCollegePhoneNumber()).isPresent()) {
            return "College Phone Number Already Exists";
        }
        if (ObjectUtils.isEmpty(collegeEntity.getCollegeType())) {
            return "Invalid College Type";
        }
        if (ObjectUtils.isEmpty(collegeEntity.getCollegeStatus())) {
            return "Invalid College Status";
        }
        if (ObjectUtils.isEmpty(collegeEntity.getCollegeAddress())) {
            return "Invalid Address, Please Write Address Details";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeAddress().getAddressLine_1())) {
            return "Invalid College AddressLine1";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeAddress().getCity()) || !collegeEntity.getCollegeAddress().getCity().matches("^[a-zA-Z ]+$")) {
            return "Invalid City";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeAddress().getPinCode()) || !collegeEntity.getCollegeAddress().getPinCode().matches("^[a-zA-Z0-9]+$")) {
            return "Invalid PinCode";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeAddress().getState()) || !collegeEntity.getCollegeAddress().getState().matches("^[a-zA-Z ]+$")) {
            return "Invalid State";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeAddress().getCountry()) || !collegeEntity.getCollegeAddress().getCountry().matches("^[a-zA-Z ]+$")) {
            return "Invalid Country";
        }

//        collegeEntity.setStartDate(new Date());
//        addressRepository.save(collegeEntity.getCollegeAddress());

        collegeRepository.save(collegeEntity);
        return "Congrats !! Your College is saved";
    }

    public String deleteCollegeById(Long collegeId) {
        Optional<CollegeEntity> checkId = collegeRepository.findById(collegeId);
        if (checkId.isEmpty()) {
            return "College does not exist";
        }
        collegeRepository.deleteById(collegeId);
        return "college id is deleted Successfully";
    }

    public String updateCollege(Long collegeId, CollegeEntity collegeEntity) {
        Optional<CollegeEntity> checkId = collegeRepository.findById(collegeId);
        if (checkId.isEmpty()) {
            return "College does not Exist";
        }

        CollegeEntity existingCollege = checkId.get();
        if (ObjectUtils.isEmpty(collegeEntity)) {
            return "Invalid College, Please Write College Details";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeCode()) || !collegeEntity.getCollegeCode().matches("^[a-zA-Z0-9]+$")) {
            return "Invalid College Code";
        }
        Optional<CollegeEntity> existingCode =
                collegeRepository.findByCollegeCode(collegeEntity.getCollegeCode());

        if (existingCode.isPresent() &&
                !existingCode.get().getId().equals(collegeId)) {
            return "College Code Already Exists";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeName()) || !collegeEntity.getCollegeName().matches("^[a-zA-Z ]+$")) {
            return "Invalid College Name";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeEmail()) || !collegeEntity.getCollegeEmail().matches("^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
            return "Invalid College Email";
        }
        Optional<CollegeEntity> existingEmail =
                collegeRepository.findByCollegeEmail(collegeEntity.getCollegeEmail());

        if (existingEmail.isPresent() && !existingEmail.get().getId().equals(collegeId)) {
            return "College Email Already Exists";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegePhoneNumber()) || !collegeEntity.getCollegePhoneNumber().matches("^[6-9][0-9]{9}$")) {
            return "Invalid College Phone Number";
        }
        Optional<CollegeEntity> existingPhone =
                collegeRepository.findByCollegePhoneNumber(collegeEntity.getCollegePhoneNumber());

        if (existingPhone.isPresent() && !existingPhone.get().getId().equals(collegeId)) {
            return "College Phone Number Already Exists";
        }
        if (ObjectUtils.isEmpty(collegeEntity.getCollegeType())) {
            return "Invalid College Type";
        }
        if (ObjectUtils.isEmpty(collegeEntity.getCollegeStatus())) {
            return "Invalid College Status";
        }
        if (ObjectUtils.isEmpty(collegeEntity.getCollegeAddress())) {
            return "Invalid Address, Please Write Address Details";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeAddress().getAddressLine_1())) {
            return "Invalid College AddressLine1";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeAddress().getCity()) || !collegeEntity.getCollegeAddress().getCity().matches("^[a-zA-Z ]+$")) {
            return "Invalid City";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeAddress().getPinCode()) || !collegeEntity.getCollegeAddress().getPinCode().matches("^[a-zA-Z0-9]+$")) {
            return "Invalid PinCode";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeAddress().getState()) || !collegeEntity.getCollegeAddress().getState().matches("^[a-zA-Z ]+$")) {
            return "Invalid State";
        }
        if (StringUtils.isBlank(collegeEntity.getCollegeAddress().getCountry()) || !collegeEntity.getCollegeAddress().getCountry().matches("^[a-zA-Z ]+$")) {
            return "Invalid Country";
        }
        existingCollege.setCollegeName(collegeEntity.getCollegeName());
        existingCollege.setCollegeCode(collegeEntity.getCollegeCode());
        existingCollege.setCollegeEmail(collegeEntity.getCollegeEmail());
        existingCollege.setCollegePhoneNumber(collegeEntity.getCollegePhoneNumber());
        existingCollege.setCollegeStatus(collegeEntity.getCollegeStatus());
        existingCollege.setCollegeType(collegeEntity.getCollegeType());
        existingCollege.getCollegeAddress().setAddressLine_1(collegeEntity.getCollegeAddress().getAddressLine_1());
        existingCollege.getCollegeAddress().setAddressLine_2(collegeEntity.getCollegeAddress().getAddressLine_2());
        existingCollege.getCollegeAddress().setCity(collegeEntity.getCollegeAddress().getCity());
        existingCollege.getCollegeAddress().setCountry(collegeEntity.getCollegeAddress().getCountry());
        existingCollege.getCollegeAddress().setPinCode(collegeEntity.getCollegeAddress().getPinCode());
        existingCollege.getCollegeAddress().setState(collegeEntity.getCollegeAddress().getState());
        collegeRepository.save(existingCollege);
        return "College Data is Updated";

    }
}
