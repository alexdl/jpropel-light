// /////////////////////////////////////////////////////////
// This file is part of Propel.
//
// Propel is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Propel is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with Propel. If not, see <http://www.gnu.org/licenses/>.
// /////////////////////////////////////////////////////////
// Authored by: Nikolaos Tountas -> salam.kaser-at-gmail.com
// /////////////////////////////////////////////////////////
package propel.core.userTypes;

import java.math.BigInteger;

/**
 * Unsigned byte data type
 */
public final class UnsignedByte
    extends NumberType
    implements Comparable<UnsignedByte>
{
  private static final long serialVersionUID = -4996773900759875703L;
  public static final UnsignedByte MIN_VALUE = new UnsignedByte((short) 0, true);
  public static final UnsignedByte MAX_VALUE = new UnsignedByte((short) 255, true);
  private final short value;

  /**
   * Initializes with the value 0
   */
  public UnsignedByte()
  {
    value = 0;
  }

  /**
   * Initializes with a string value.
   * 
   * @throws NumberFormatException The argument is out of range
   */
  public UnsignedByte(String value)
  {
    this.value = Short.parseShort(value);

    if (this.value < MIN_VALUE.value)
      throw new NumberFormatException("The value is too small for be an unsigned byte: " + value);
    if (this.value > MAX_VALUE.value)
      throw new NumberFormatException("The value is too large for be an unsigned byte: " + value);
  }

  /**
   * Initializes with a primitive number type
   * 
   * @throws NumberFormatException The argument is out of range
   */
  public UnsignedByte(short value)
  {
    this.value = value;

    if (this.value < MIN_VALUE.value)
      throw new NumberFormatException("The value is too small for be an unsigned byte: " + value);
    if (this.value > MAX_VALUE.value)
      throw new NumberFormatException("The value is too large for be an unsigned byte: " + value);
  }

  /**
   * Only used internally to initialize static final fields.
   */
  private UnsignedByte(short value, boolean dummy)
  {
    this.value = value;
  }

  /**
   * Initializes with a BigInteger type
   * 
   * @throws NumberFormatException The argument is out of range
   */
  public UnsignedByte(BigInteger value)
  {
    this(value.toString(10));
  }

  /**
   * Initializes with another signed byte
   * 
   * @throws NullPointerException When the argument is null.
   */
  public UnsignedByte(UnsignedByte other)
  {
    if (other == null)
      throw new NullPointerException("other");
    this.value = other.value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BigInteger bigIntegerValue()
  {
    return new BigInteger(toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double doubleValue()
  {
    return value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public float floatValue()
  {
    return value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public byte byteValue()
  {
    return (new Short(value)).byteValue();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public short shortValue()
  {
    return value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int intValue()
  {
    return value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public long longValue()
  {
    return value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString()
  {
    return Short.valueOf(value).toString();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object other)
  {
    if (other == null)
      return false;

    if (other == this)
      return true;

    if (!(other instanceof UnsignedByte))
      return false;

    UnsignedByte sb = (UnsignedByte) other;
    return value == sb.value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode()
  {
    return value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int compareTo(UnsignedByte other)
  {
    if (other == null)
      throw new NullPointerException("other");

    if (value < other.value)
      return -1;
    if (value > other.value)
      return 1;

    return 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object clone()
  {
    return new UnsignedByte(this);
  }
}
