package com.arturomarmolejo.locationsdk.utils

class LocationIsDisabled(m: String = "Location is not enabled"): Exception(m)

class RetrieveLocationException(m: String = "Unexpected error while retrieving location"): Exception(m)