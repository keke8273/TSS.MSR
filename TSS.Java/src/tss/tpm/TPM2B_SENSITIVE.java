package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** The TPM2B_SENSITIVE structure is used as a parameter in TPM2_LoadExternal(). It is an
 *  unencrypted sensitive area but it may be encrypted using parameter encryption.
 */
public class TPM2B_SENSITIVE extends TpmStructure
{
    /** An unencrypted sensitive area  */
    public TPMT_SENSITIVE sensitiveArea;
    
    public TPM2B_SENSITIVE() {}
    
    /** @param _sensitiveArea An unencrypted sensitive area  */
    public TPM2B_SENSITIVE(TPMT_SENSITIVE _sensitiveArea) { sensitiveArea = _sensitiveArea; }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeShort(sensitiveArea != null ? sensitiveArea.toTpm().length : 0);
        if (sensitiveArea != null)
            sensitiveArea.toTpm(buf);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _size = buf.readShort() & 0xFFFF;
        buf.structSize.push(buf.new SizedStructInfo(buf.curPos(), _size));
        sensitiveArea = TPMT_SENSITIVE.fromTpm(buf);
        buf.structSize.pop();
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPM2B_SENSITIVE fromBytes (byte[] byteBuf) 
    {
        TPM2B_SENSITIVE ret = new TPM2B_SENSITIVE();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2B_SENSITIVE fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2B_SENSITIVE fromTpm (InByteBuf buf) 
    {
        TPM2B_SENSITIVE ret = new TPM2B_SENSITIVE();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2B_SENSITIVE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMT_SENSITIVE", "sensitiveArea", sensitiveArea);
    }
}

//<<<
