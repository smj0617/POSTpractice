package com.back.global.rsData;

// <T> : data 칸에 무엇이 들어갈지는 사용하는 쪽에서 정함
// RsData<PostDto> → data가 PostDto, RsData<Void> → data가 없음(null)
public record RsData<T>(String resultCode, String msg, T data) {

    // data 없이 코드와 메시지만 줄 때 쓰는 생성자 → data는 null
    public RsData(String resultCode, String msg) {
        this(resultCode, msg, null);
    }
}