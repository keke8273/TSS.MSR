package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** NOTE 1 This command is deprecated, and TPM2_EncryptDecrypt2() is preferred. This
 *  should be reflected in platform-specific specifications.
 */
public class EncryptDecryptResponse extends TpmStructure
{
    /** Encrypted or decrypted output  */
    public byte[] outData;
    
    /** Chaining value to use for IV in next round  */
    public byte[] ivOut;
    
    public EncryptDecryptResponse() {}
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeSizedByteBuf(outData);
        buf.writeSizedByteBuf(ivOut);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _outDataSize = buf.readShort() & 0xFFFF;
        outData = new byte[_outDataSize];
        buf.readArrayOfInts(outData, 1, _outDataSize);
        int _ivOutSize = buf.readShort() & 0xFFFF;
        ivOut = new byte[_ivOutSize];
        buf.readArrayOfInts(ivOut, 1, _ivOutSize);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static EncryptDecryptResponse fromBytes (byte[] byteBuf) 
    {
        EncryptDecryptResponse ret = new EncryptDecryptResponse();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static EncryptDecryptResponse fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static EncryptDecryptResponse fromTpm (InByteBuf buf) 
    {
        EncryptDecryptResponse ret = new EncryptDecryptResponse();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_EncryptDecrypt_RESPONSE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "byte", "outData", outData);
        _p.add(d, "byte", "ivOut", ivOut);
    }
}

//<<<
