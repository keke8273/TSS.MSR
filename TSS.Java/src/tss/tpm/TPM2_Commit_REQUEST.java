package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** TPM2_Commit() performs the first part of an ECC anonymous signing operation. The TPM
 *  will perform the point multiplications on the provided points and return intermediate
 *  signing values. The signHandle parameter shall refer to an ECC key and the signing
 *  scheme must be anonymous (TPM_RC_SCHEME).
 */
public class TPM2_Commit_REQUEST extends TpmStructure
{
    /** Handle of the key that will be used in the signing operation
     *  Auth Index: 1
     *  Auth Role: USER
     */
    public TPM_HANDLE signHandle;
    
    /** A point (M) on the curve used by signHandle  */
    public TPMS_ECC_POINT P1;
    
    /** Octet array used to derive x-coordinate of a base point  */
    public byte[] s2;
    
    /** Y coordinate of the point associated with s2  */
    public byte[] y2;
    
    public TPM2_Commit_REQUEST() { signHandle = new TPM_HANDLE(); }
    
    /** @param _signHandle Handle of the key that will be used in the signing operation
     *         Auth Index: 1
     *         Auth Role: USER
     *  @param _P1 A point (M) on the curve used by signHandle
     *  @param _s2 Octet array used to derive x-coordinate of a base point
     *  @param _y2 Y coordinate of the point associated with s2
     */
    public TPM2_Commit_REQUEST(TPM_HANDLE _signHandle, TPMS_ECC_POINT _P1, byte[] _s2, byte[] _y2)
    {
        signHandle = _signHandle;
        P1 = _P1;
        s2 = _s2;
        y2 = _y2;
    }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeShort(P1 != null ? P1.toTpm().length : 0);
        if (P1 != null)
            P1.toTpm(buf);
        buf.writeSizedByteBuf(s2);
        buf.writeSizedByteBuf(y2);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _P1Size = buf.readShort() & 0xFFFF;
        buf.structSize.push(buf.new SizedStructInfo(buf.curPos(), _P1Size));
        P1 = TPMS_ECC_POINT.fromTpm(buf);
        buf.structSize.pop();
        int _s2Size = buf.readShort() & 0xFFFF;
        s2 = new byte[_s2Size];
        buf.readArrayOfInts(s2, 1, _s2Size);
        int _y2Size = buf.readShort() & 0xFFFF;
        y2 = new byte[_y2Size];
        buf.readArrayOfInts(y2, 1, _y2Size);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPM2_Commit_REQUEST fromBytes (byte[] byteBuf) 
    {
        TPM2_Commit_REQUEST ret = new TPM2_Commit_REQUEST();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2_Commit_REQUEST fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2_Commit_REQUEST fromTpm (InByteBuf buf) 
    {
        TPM2_Commit_REQUEST ret = new TPM2_Commit_REQUEST();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_Commit_REQUEST");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPM_HANDLE", "signHandle", signHandle);
        _p.add(d, "TPMS_ECC_POINT", "P1", P1);
        _p.add(d, "byte", "s2", s2);
        _p.add(d, "byte", "y2", y2);
    }
}

//<<<
