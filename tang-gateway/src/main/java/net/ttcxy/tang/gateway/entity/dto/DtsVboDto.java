package net.ttcxy.tang.gateway.entity.dto;

import net.ttcxy.tang.model.DtsVbo;
import net.ttcxy.tang.model.UtsAuthor;

public class DtsVboDto {

    private UtsAuthor utsAuthor;

    private DtsVbo dtsVbo;

    public UtsAuthor getUtsAuthor() {
        return utsAuthor;
    }

    public void setUtsAuthor(UtsAuthor utsAuthor) {
        this.utsAuthor = utsAuthor;
    }

    public DtsVbo getDtsVbo() {
        return dtsVbo;
    }

    public void setDtsVbo(DtsVbo dtsVbo) {
        this.dtsVbo = dtsVbo;
    }
}
