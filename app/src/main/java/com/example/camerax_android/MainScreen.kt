package com.example.camerax_android

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen(){
    val cameraPermissionState : PermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)
    MainContent(
        hasPermission = cameraPermissionState.status.isGranted,
        onRequestPermission = cameraPermissionState::launchPermissionRequest
    )
}
@Composable
private fun MainContent(
    hasPermission : Boolean,
    onRequestPermission : () -> Unit
){
    if(hasPermission){
        CameraScreen()
    }else{
        NoPermissionScreen(onRequestPermission)
    }
}

@Preview
@Composable
private fun Private_MainContent(){
    MainContent(
        hasPermission = true,
        onRequestPermission = {}
    )
}