package com.example.music.exoplayer.callbacks

import android.app.Service
import android.widget.Toast
import com.example.music.exoplayer.MusicService
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player

class MusicPlayerListener(
    private val musicService: MusicService
) : Player.Listener {
    override fun onPlaybackStateChanged(playbackState: Int) {
        super.onPlaybackStateChanged(playbackState)
        if (playbackState == Player.STATE_READY) {
            musicService.stopForeground(Service.STOP_FOREGROUND_DETACH)
        }
    }

    override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
        super.onPlayWhenReadyChanged(playWhenReady, reason)
        if (!playWhenReady) {
            musicService.stopForeground(Service.STOP_FOREGROUND_DETACH)
        }
    }

    override fun onPlayerError(error: PlaybackException) {
        super.onPlayerError(error)
        Toast.makeText(musicService, "An unknown error occurred", Toast.LENGTH_LONG).show()
    }
}