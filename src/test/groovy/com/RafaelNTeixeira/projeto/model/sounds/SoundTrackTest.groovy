package com.RafaelNTeixeira.projeto.model.sounds

import org.mockito.Mock
import spock.lang.Specification

import javax.sound.sampled.Clip
import javax.sound.sampled.FloatControl

class SoundTrackTest extends Specification{

    private def soundTrack
    private def clip

    def setup() {
        String path = "/src/main/resources/Sounds/soundTrack.wav"
        soundTrack = new SoundTrack(path)
        clip = Mock(Clip.class)
        soundTrack.setSound(clip)
    }

    def 'Create and load sound'(){
        given:
        String path = "/src/main/resources/Sounds/soundTrack.wav"
        soundTrack = new SoundTrack(path)

        when:
        FloatControl floatControl = soundTrack.getSound().getControl(FloatControl.Type.MASTER_GAIN)

        then:
        floatControl.getValue() == -25.0f
        soundTrack != null
    }

}
