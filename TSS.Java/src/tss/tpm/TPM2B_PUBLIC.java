package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This sized buffer is used to embed a TPMT_PUBLIC in a load command and in any response
 *  that returns a public area.
 */
public class TPM2B_PUBLIC extends TpmStructure
{
    /** The public area
     *  NOTE The + indicates that the caller may specify that use of TPM_ALG_NULL is allowed
     *  for nameAlg.
     */
    public TPMT_PUBLIC publicArea;
    
    public TPM2B_PUBLIC() {}
    
    /** @param _publicArea The public area
     *         NOTE The + indicates that the caller may specify that use of TPM_ALG_NULL is
     *         allowed for nameAlg.
     */
    public TPM2B_PUBLIC(TPMT_PUBLIC _publicArea) { publicArea = _publicArea; }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeShort(publicArea != null ? publicArea.toTpm().length : 0);
        if (publicArea != null)
            publicArea.toTpm(buf);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _size = buf.readShort() & 0xFFFF;
        buf.structSize.push(buf.new SizedStructInfo(buf.curPos(), _size));
        publicArea = TPMT_PUBLIC.fromTpm(buf);
        buf.structSize.pop();
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPM2B_PUBLIC fromBytes (byte[] byteBuf) 
    {
        TPM2B_PUBLIC ret = new TPM2B_PUBLIC();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2B_PUBLIC fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2B_PUBLIC fromTpm (InByteBuf buf) 
    {
        TPM2B_PUBLIC ret = new TPM2B_PUBLIC();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2B_PUBLIC");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMT_PUBLIC", "publicArea", publicArea);
    }
}

//<<<
