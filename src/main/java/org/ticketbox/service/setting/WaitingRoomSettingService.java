package org.ticketbox.service.setting;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketbox.database.model.WaitingRoomSetting;
import org.ticketbox.database.repository.WaitingRoomSettingRepository;
import org.ticketbox.shared.constant.ErrorCodeConstant;
import org.ticketbox.shared.exception.custom.BadRequestException;

@Service
@AllArgsConstructor
public class WaitingRoomSettingService {
    private WaitingRoomSettingRepository waitingRoomSettingRepository;

    public WaitingRoomSetting createWaitingRoomSetting(WaitingRoomSetting waitingRoomSetting) {
        return waitingRoomSettingRepository.save(waitingRoomSetting);
    }

    public WaitingRoomSetting editWaitingRoomSetting(Integer id, WaitingRoomSetting waitingRoomSetting) {
        WaitingRoomSetting isExist = waitingRoomSettingRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorCodeConstant.WAITING_ROOM_SETTING_NOT_EXIST));

        waitingRoomSetting.setId(isExist.getId());
        return waitingRoomSettingRepository.save(waitingRoomSetting);
    }

    public WaitingRoomSetting getWaitingRoomById(Integer id) {
        return waitingRoomSettingRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorCodeConstant.WAITING_ROOM_SETTING_NOT_EXIST));
    }
}
